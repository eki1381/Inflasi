package com.eki.ryh.inflasi.Database;

import android.support.annotation.NonNull;

import com.eki.ryh.inflasi.Model.Questionnaire;

import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by user on 14/02/2018.
 */

public class QuestionnaireRepository implements QuestionnaireDataSource {

    private static QuestionnaireRepository INSTANCE = null;

    private final QuestionnaireDataSource mQuestionnaireLocalDataSource;

    private QuestionnaireRepository(@NonNull QuestionnaireDataSource questionnaireLocalDataSource) {
        mQuestionnaireLocalDataSource = checkNotNull(questionnaireLocalDataSource);
    }

    public static QuestionnaireRepository getInstance(QuestionnaireDataSource questionnaireLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new QuestionnaireRepository(questionnaireLocalDataSource);
        }
        return INSTANCE;
    }

    @Override
    public void saveQuestionnaire(Questionnaire questionnaire) {
        checkNotNull(questionnaire);
        mQuestionnaireLocalDataSource.saveQuestionnaire(questionnaire);
    }

    @Override
    public void updateQuestionnaire(Questionnaire questionnaire, UpdateQuestionnaireCallback callback) {
        checkNotNull(questionnaire);
        mQuestionnaireLocalDataSource.updateQuestionnaire(questionnaire, new UpdateQuestionnaireCallback() {
            @Override
            public void onQuestionnaireUpdated(int respond) {
                callback.onQuestionnaireUpdated(respond);
            }
        });
    }

    @Override
    public void getAllQuestionnaire(@NonNull final LoadAllQuestionnaireCallback callback) {
        checkNotNull(callback);
        mQuestionnaireLocalDataSource.getAllQuestionnaire(new LoadAllQuestionnaireCallback() {
            @Override
            public void onAllQuestionnaireLoaded(List<Questionnaire> questionnaires) {
                callback.onAllQuestionnaireLoaded(questionnaires);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    @Override
    public void getBulanDistinct(@NonNull LoadBulanDistinctCallback callback) {
        checkNotNull(callback);
        mQuestionnaireLocalDataSource.getBulanDistinct(new LoadBulanDistinctCallback() {

            @Override
            public void onBulanDistinctLoaded(List<String> bulans) {
                callback.onBulanDistinctLoaded(bulans);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    @Override
    public void getQuestionnaireByBulan(String bulan, @NonNull LoadQuestionnaireByBulanCallback callback) {
        checkNotNull(callback);
        mQuestionnaireLocalDataSource.getQuestionnaireByBulan(bulan, new LoadQuestionnaireByBulanCallback() {
            @Override
            public void onQuestionnaireByBulanLoaded(List<Questionnaire> questionnaires) {
                callback.onQuestionnaireByBulanLoaded(questionnaires);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

    @Override
    public void getQuestionnaireById(int questId, @NonNull LoadQuestionnaireByIdCallback callback) {
        checkNotNull(callback);
        mQuestionnaireLocalDataSource.getQuestionnaireById(questId, new LoadQuestionnaireByIdCallback() {
            public void onQuestionnaireByIdLoaded(List<Questionnaire> questionnaires) {
                callback.onQuestionnaireByIdLoaded(questionnaires);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }
}
