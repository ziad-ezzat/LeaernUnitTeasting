package com.example.learnteasting

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class UserDaoTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var userDao: UserDao
    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = AppDatabase.getInstance(context)
        userDao = db.userDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertAndRetrieveUsers() = runBlocking {
        val users = listOf(
            User(1, "user1", "user1@example.com"),
            User(2, "user2", "user2@example.com")
        )

        userDao.insertUsers(users)
        val retrievedUsers = userDao.getUsers().value!!

        assertEquals(retrievedUsers.size,users.size)
        assert(retrievedUsers.containsAll(users))
    }
}