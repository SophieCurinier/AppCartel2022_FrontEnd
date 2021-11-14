package com.example.cartel2022.model

data class MatchDto(val id:Long,
                    var date:String,
                    val sport:SportDto,
                    var team1:TeamDto,
                    var team2:TeamDto,
                    var score1:Long,
                    var score2:Long)
