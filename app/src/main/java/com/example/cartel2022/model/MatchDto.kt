package com.example.cartel2022.model

data class MatchDto(val id:Long,
                    var date:String,
                    var team1:String,
                    var team2:String,
                    val sport:String,
                    var score1:Long,
                    var score2:Long)
