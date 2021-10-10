package com.cevik.viewpagerproject.data

class DataGenerator {
    fun generate(count:Int):List<Call>{
        var callList= arrayListOf<Call>()



        for(i in 1..count){
            var callModel=Call(
                index=0,
                name = "ali",
                text = "asdasdasdasdsad"
            )
            callModel.index=i
            callList.add(callModel)
        }
        return callList
    }
}