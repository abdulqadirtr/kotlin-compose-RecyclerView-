package app.compose.recyclerviewcompose

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ObjectViewModel : ViewModel() {

    private val _objects = MutableStateFlow<List<Objects>>(emptyList())
    val objects: StateFlow<List<Objects>> = _objects


    init {
        fetchData()
    }


    private fun fetchData() {

        viewModelScope.launch {

            try {
                val response = NetworkClient.api.getObjects()

                _objects.value = response
            } catch (e: Exception) {

                // _objects.value = e

            }

        }

    }

}