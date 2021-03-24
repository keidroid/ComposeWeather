package red.torch.composeweather.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import red.torch.composeweather.data.RepoResult
import red.torch.composeweather.data.Weather
import red.torch.composeweather.data.WeatherInfo
import red.torch.composeweather.data.WeatherListInfo
import red.torch.composeweather.data.repository.WeatherRepository

class WeatherRepositoryMock : WeatherRepository {
    override suspend fun getList(): RepoResult<WeatherListInfo> {
        return RepoResult.Success(
            WeatherListInfo(
                "location",
                "country",
                WeatherInfo("", "", Weather.Rainy, 0),
                emptyList()
            )
        )
    }
}

class WeatherListViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: WeatherListViewModel

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        viewModel = WeatherListViewModel(WeatherRepositoryMock())
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }
}
