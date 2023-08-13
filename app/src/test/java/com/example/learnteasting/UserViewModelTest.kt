import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.learnteasting.User
import com.example.learnteasting.UserRepository
import com.example.learnteasting.UserViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

class UserViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var repository: UserRepository

    private lateinit var viewModel: UserViewModel

    @Before
    fun setup() {
        viewModel = UserViewModel(repository)
    }

    @Test
    fun `insertUser should call repository's insert`() = runBlockingTest {
        // Given
        val users = listOf(
            User(1, "name", "email"),
            User(2, "name2", "email2"),
            User(3, "name3", "email3")
        )

        // When
        viewModel.insert(users)

        // Then
        verify(repository, times(1)).insert(users)
    }
}