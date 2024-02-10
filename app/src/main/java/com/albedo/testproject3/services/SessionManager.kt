package com.albedo.testproject3.services

import android.content.Context
import android.content.SharedPreferences
import com.albedo.testproject3.services.ConstantsSource.USER_SESSION_DATA
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SessionManager @Inject constructor(@ApplicationContext context: Context) {
    // ShoppingAppSessionManager is needed for getting current user
    private var userSectionSharedPreferences: SharedPreferences = context.getSharedPreferences(USER_SESSION_DATA, Context.MODE_PRIVATE)
    private var editor: SharedPreferences.Editor = userSectionSharedPreferences.edit()


    fun updateDataLoginSession(noNeedToUpdate: Boolean) {
        editor.putBoolean(ConstantsSource.NoNeedToUpdate, noNeedToUpdate)
        editor.commit()
    }
    fun deleteLoginSession() {
        editor.clear()
        editor.commit()
    }


    fun noNeedToUpdate(): Boolean = userSectionSharedPreferences.getBoolean(ConstantsSource.NoNeedToUpdate, false)
}