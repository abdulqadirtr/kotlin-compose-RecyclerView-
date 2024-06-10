package app.compose.recyclerviewcompose

data class Objects(
    val id : Int,
    val name : String,
    val data : Data

)
data class Data(
    val color : String,
    val capacity : String
)