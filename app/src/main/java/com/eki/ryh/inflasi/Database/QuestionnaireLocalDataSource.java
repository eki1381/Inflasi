package com.eki.ryh.inflasi.Database;

import android.support.annotation.NonNull;

import com.eki.ryh.inflasi.Model.Merek;
import com.eki.ryh.inflasi.Model.Questionnaire;
import com.eki.ryh.inflasi.Utils.AppExecutors;

import java.util.List;

/**
 * Created by user on 14/02/2018.
 */

public class QuestionnaireLocalDataSource implements QuestionnaireDataSource {

    private static volatile QuestionnaireLocalDataSource INSTANCE;

    private QuestionnaireDao mQuestionnaireDao;

    private AppExecutors mAppExecutors;

    private QuestionnaireLocalDataSource(@NonNull AppExecutors appExecutors,
                                         @NonNull QuestionnaireDao questionnaireDao) {
        mAppExecutors = appExecutors;
        mQuestionnaireDao = questionnaireDao;
    }

    public static QuestionnaireLocalDataSource getInstance(@NonNull AppExecutors appExecutors,
                                                   @NonNull QuestionnaireDao questionnaireDao) {
        if (INSTANCE == null) {
            synchronized (QuestionnaireLocalDataSource.class) {
                if (INSTANCE == null) {
                    INSTANCE = new QuestionnaireLocalDataSource(appExecutors, questionnaireDao);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void saveQuestionnaire(final Questionnaire questionnaire) {
        Runnable saveRunnable = new Runnable() {
            @Override
            public void run() {
                mQuestionnaireDao.insertQuestionnaire(questionnaire);
            }
        };
        mAppExecutors.diskIO().execute(saveRunnable);
    }

    @Override
    public void updateQuestionnaire(Questionnaire questionnaire, UpdateQuestionnaireCallback callback) {
        Runnable saveRunnable = new Runnable() {
            @Override
            public void run() {
                int respond = mQuestionnaireDao.updateQuestionnaire(questionnaire);
                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        callback.onQuestionnaireUpdated(respond);
                    }
                });
            }
        };
        mAppExecutors.diskIO().execute(saveRunnable);
    }

    @Override
    public void getAllQuestionnaire(@NonNull final LoadAllQuestionnaireCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<Questionnaire> questionnaires = mQuestionnaireDao.getAllQuestionnaire();
                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (questionnaires.isEmpty()) {
                            callback.onDataNotAvailable();
                        } else {
                            callback.onAllQuestionnaireLoaded(questionnaires);
                        }
                    }
                });
            }
        };
        mAppExecutors.diskIO().execute(runnable);
    }

    @Override
    public void getBulanDistinct(@NonNull LoadBulanDistinctCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<String> bulans = mQuestionnaireDao.getBulanDistinct();
                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (bulans.isEmpty()) {
                            callback.onDataNotAvailable();
                        } else {
                            callback.onBulanDistinctLoaded(bulans);
                        }
                    }
                });
            }
        };
        mAppExecutors.diskIO().execute(runnable);
    }

    @Override
    public void getQuestionnaireByBulan(String bulan, @NonNull LoadQuestionnaireByBulanCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<Questionnaire> questionnaires = mQuestionnaireDao.getQuestionnaireByBulan(bulan);
                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (questionnaires.isEmpty()) {
                            callback.onDataNotAvailable();
                        } else {
                            callback.onQuestionnaireByBulanLoaded(questionnaires);
                        }
                    }
                });
            }
        };
        mAppExecutors.diskIO().execute(runnable);
    }

    @Override
    public void getQuestionnaireById(int questId, @NonNull LoadQuestionnaireByIdCallback callback) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<Questionnaire> questionnaires = mQuestionnaireDao.getQuestionnaireById(questId);
                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if (questionnaires.isEmpty()) {
                            callback.onDataNotAvailable();
                        } else {
                            callback.onQuestionnaireByIdLoaded(questionnaires);
                        }
                    }
                });
            }
        };
        mAppExecutors.diskIO().execute(runnable);
    }
}
