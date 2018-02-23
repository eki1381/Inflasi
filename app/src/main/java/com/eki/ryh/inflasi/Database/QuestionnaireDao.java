package com.eki.ryh.inflasi.Database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.eki.ryh.inflasi.Model.Questionnaire;

import java.util.List;

/**
 * Created by user on 14/02/2018.
 */

@Dao
public interface QuestionnaireDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertQuestionnaire(Questionnaire questionnaire);

    @Query("SELECT * FROM Questionnaire")
    List<Questionnaire> getAllQuestionnaire();

    @Query("SELECT DISTINCT bulan FROM Questionnaire")
    List<String> getBulanDistinct();

    @Query("SELECT * FROM Questionnaire WHERE bulan LIKE :bulan")
    List<Questionnaire> getQuestionnaireByBulan(String bulan);

    @Query("SELECT * FROM Questionnaire WHERE questId = :questId")
    List<Questionnaire> getQuestionnaireById(int questId);

    @Update
    int updateQuestionnaire(Questionnaire questionnaire);
}
