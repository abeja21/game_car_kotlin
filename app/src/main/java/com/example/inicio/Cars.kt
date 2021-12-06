package com.example.inicio



class Cars (val nombre:String, val velocidadMaxima:Int,val aceleracion:Int,val desaceleracion:Int,val gasolina:Int,val design:Int,val fondo:Int) {

    var velin: Int = 0
    var fuel = 0;
    var dr = 0;
    var ingame=true
    fun acelerate() {

        this.velin += this.aceleracion
        if (this.velin > this.velocidadMaxima) {
            this.velin = this.velocidadMaxima
        } else {
            this.velin;
        }
        this.dr+=this.velin
        this.combustion()
    }

    fun frenar(){

        if (this.velin<20){
            acelerate()
        }else{
            this.velin-=this.desaceleracion
            this.combustion()
        }
        this.dr+=this.velin
    }

    fun combustion(){
        this.fuel=this.velin/100
    }

    fun repostar(){
        this.fuel+=10;
        if (this.fuel>this.gasolina){
            this.fuel=this.gasolina
        }else{
            this.fuel
        }
    }
}
