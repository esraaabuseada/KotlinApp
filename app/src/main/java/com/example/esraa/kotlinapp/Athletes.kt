package com.example.esraa.kotlinapp

class  Athletes{
    private  var name:String=""
    private  var image:String=""
   private var brief:String=""

    public fun setName(nameObj:String){
        name=nameObj;
    }
    public fun setImage(imageObj:String){
        image=imageObj;
    }
    public fun setBrief(briefObj:String){
        brief=briefObj;
    }

    public fun getName():String{
        return name
    }
    public fun getImage():String{
        return image
    }
    public fun getBrief():String{
        return brief
    }









}

