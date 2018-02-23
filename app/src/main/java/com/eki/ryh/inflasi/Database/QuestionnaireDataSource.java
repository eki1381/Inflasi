package com.eki.ryh.inflasi.Database;

import android.support.annotation.NonNull;

import com.eki.ryh.inflasi.Model.Questionnaire;

import java.util.List;

/**
 * Created by user on 14/02/2018.
 */

public interface QuestionnaireDataSource {
    interface UpdateQuestionnaireCallback {
        void onQuestionnaireUpdated(int respond);
    }

    interface LoadAllQuestionnaireCallback {
        void onAllQuestionnaireLoaded(List<Questionnaire> questionnaires);

        void onDataNotAvailable();
    }

    interface LoadBulanDistinctCallback {
        void onBulanDistinctLoaded(List<String> bulans);

        void onDataNotAvailable();
    }

    interface LoadQuestionnaireByBulanCallback {
        void onQuestionnaireByBulanLoaded(List<Questionnaire> questionnaires);

        void onDataNotAvailable();
    }

    interface LoadQuestionnaireByIdCallback {
        void onQuestionnaireByIdLoaded(List<Questionnaire> questionnaires);

        void onDataNotAvailable();
    }

    void saveQuestionnaire(Questionnaire questionnaire);

    void updateQuestionnaire(Questionnaire questionnaire, @NonNull UpdateQuestionnaireCallback callback);

    void getAllQuestionnaire(@NonNull LoadAllQuestionnaireCallback callback);

    void getBulanDistinct(@NonNull LoadBulanDistinctCallback callback);

    void getQuestionnaireByBulan(String bulan, @NonNull LoadQuestionnaireByBulanCallback callback);

    void getQuestionnaireById(int questId, @NonNull LoadQuestionnaireByIdCallback callback);
}
