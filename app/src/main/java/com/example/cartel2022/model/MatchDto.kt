package com.example.cartel2022.model

data class MatchDto(val id:Long,
                    var date:String,
                    val sport:String,
                    var team1:String,
                    var team2:String,
                    var score_1:Long?,
                    var score_2:Long?)

