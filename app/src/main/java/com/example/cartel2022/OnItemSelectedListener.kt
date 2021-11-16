package com.example.cartel2022

//Items where a string like a name of school and an id like schoolid are used
interface OnItemSelectedListener {
    fun onItemSelected(id: Long, name: String)
}
//Items with only a string like an url is used
interface OnUrlSelectedListener {
    fun onUrlSelected(url : String)
}