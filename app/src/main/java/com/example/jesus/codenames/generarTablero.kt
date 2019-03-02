package com.example.jesus.codenames

import android.opengl.GLES20
import android.util.Log
import android.util.LogPrinter

class generarTablero {


}
fun generar_tablero(): Array<Array<Int>> {
    var altr = (Math.random() *2).toInt()
    var tablero = arrayOf<Array<Int>>()
    when(altr){
        0-> tablero = generar_rojo()

        1-> tablero = generar_azul()

    }
    return  tablero
}

fun generar_rojo(): Array<Array<Int>> {
    var cinema = arrayOf<Array<Int>>()
    var r = 0
    var b = 0
    var m = 0
    var n = 0
    val rg = 9
    val bg = 8
    val mg = 1
    val ng = 7
    for (i in 0..4) {
        var array = arrayOf<Int>()
        for (j in 0..4) {
            var rndm = (Math.random() *4).toInt()
            when(rndm){
                //para cuando toca rojo
                0-> if (r <rg){
                    r++

                }else{
                    //si solo los red estan llenos
                    if((b < bg) && (n < ng) && (m < mg)) {
                        rndm = 1 + (Math.random() * 3).toInt()
                        when(rndm){
                            1-> b++
                            2-> n++
                            3-> m++
                        }
                    }else{
                        if ((b < bg)&& (n < ng)){
                            rndm = 1 + (Math.random() *2).toInt()
                            when(rndm){
                                1-> b++
                                2-> n++
                            }
                        }else{
                            if((b < bg) && (m < mg)){
                                rndm = 1 + (Math.random() * 2).toInt()
                                if (rndm == 2){
                                    rndm = 3
                                }
                                when(rndm){
                                    1-> b++
                                    3-> m++
                                }
                            }else{
                                if ((n < ng) && (m < mg)){
                                    rndm = 2 + (Math.random() * 2).toInt()
                                    when(rndm){
                                        2-> n++
                                        3-> m++
                                    }
                                }else{
                                    if(m < mg){
                                        rndm = 3
                                        m++
                                    }else{
                                        if(n < ng){
                                            rndm = 2
                                            n++
                                        }else{
                                            if(b < bg){
                                                rndm = 1
                                                b++
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                //para cuando toca azul
                1->if (b < bg){
                    b++
                }else{
                    if((r < rg) && (n < ng)&& (m < mg)){
                        rndm = (Math.random()*4).toInt()
                        if(rndm == 1){
                            rndm = 2+ (Math.random()*2).toInt()
                        }
                        when(rndm){
                            0->r++
                            2->n++
                            3->m++
                        }
                    }else{
                        if (r < rg && n < ng){
                            rndm = (Math.random()*2).toInt()
                            if (rndm== 1){
                                rndm = 2
                            }
                            when(rndm){
                                0->r++
                                2->n++
                            }
                        }else{
                            if (r < rg && m < mg){
                                rndm = (Math.random()*2).toInt()
                                if (rndm== 1){
                                    rndm = 3
                                }
                                when(rndm){
                                    0->r++
                                    3->m++
                                }
                            }else{
                                if(n < ng && m < mg){
                                    rndm = 2+(Math.random()*2).toInt()
                                    when(rndm){
                                        2-> n++
                                        3-> m++
                                    }
                                }else{
                                    if (r < rg){
                                        rndm = 0
                                        r++
                                    }else{
                                        if(n < ng){
                                            rndm = 2
                                            n++
                                        }else{
                                            if(m < mg){
                                                rndm = 3
                                                m++
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
                //para cuando toca uno normal
                2-> if (n < ng){
                    n++
                }else{
                    if (r < rg && b < bg && m < mg){
                        rndm = (Math.random()*3).toInt()
                        if(rndm == 2){
                            rndm = 3
                        }
                        when(rndm){
                            0->r++
                            1->b++
                            3->m++
                        }
                    }else{
                        if(r < rg && b < bg){
                            rndm =(Math.random()*2).toInt()
                            when(rndm){
                                0->r++
                                1->b++
                            }
                        }else{
                            if(r < rg && m < mg){
                                rndm = (Math.random()*2).toInt()
                                if(rndm == 1){
                                    rndm = 3
                                }
                                when(rndm){
                                    0->r++
                                    3->m++

                                }
                            }else{
                                if(b < bg && m < mg){
                                    rndm = 1+(Math.random()*2).toInt()
                                    if(rndm == 2){
                                        rndm = 3
                                    }
                                    when(rndm){
                                        1->b++
                                        3->m++
                                    }
                                }else{
                                    if(b < bg){
                                        rndm = 1
                                        b++
                                    }else{
                                        if(m < mg){
                                            rndm = 3
                                            m++
                                        }else{
                                            if(r < rg){
                                                rndm = 0
                                                r++
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                //para cuando toca asesino
                3->if (m <1) {
                    m++
                } else{
                    if (r < rg && b < bg && n < ng){
                        rndm = (Math.random()*3).toInt()
                        when(rndm){
                            0->r++
                            1->b++
                            2->n++
                        }
                    }else{
                        if(r< rg && b < bg){
                            rndm = (Math.random()*2).toInt()
                            when(rndm){
                                0->r++
                                1->b++
                            }
                        }else{
                            if(r < rg && n < ng){
                                rndm = (Math.random()*2).toInt()
                                if(rndm == 1){
                                    rndm = 2
                                }
                                when(rndm){
                                    0->r++
                                    2->n++
                                }
                            }else{
                                if(b < bg && n < ng){
                                    rndm = 1+(Math.random()*2).toInt()
                                    when(rndm){
                                        1->b++
                                        2->n++
                                    }
                                }else{
                                    if(r < rg){
                                        rndm = 0
                                        r++
                                    }else{
                                        if(b < bg){
                                            rndm = 1
                                            b++
                                        }else{
                                            if(n < ng){
                                                rndm = 2
                                                n++
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                //Aqui ya se escogio el número

            }
            array += rndm

        }
        cinema += array
    }
   /* for (array in cinema) {
        for (value in array) {
            print("$value ")
        }
        println()
    }

    print("rojo: "+r + "\n" + "azul " + b + "\n"+ "normal "+ n + "\n"+ "asesino " + m)

    print("\n"+"4,3: " + cinema[4][3])*/
    return cinema
}

fun generar_azul(): Array<Array<Int>> {
    var cinema = arrayOf<Array<Int>>()
    var r = 0
    var b = 0
    var m = 0
    var n = 0
    val rg = 8
    val bg = 9
    val mg = 1
    val ng = 7
    for (i in 0..4) {
        var array = arrayOf<Int>()
        for (j in 0..4) {
            var rndm = (Math.random() *4).toInt()
            when(rndm){
                //para cuando toca rojo
                0-> if (r <rg){
                    r++

                }else{
                    //si solo los red estan llenos
                    if((b < bg) && (n < ng) && (m < mg)) {
                        rndm = 1 + (Math.random() * 3).toInt()
                        when(rndm){
                            1-> b++
                            2-> n++
                            3-> m++
                        }
                    }else{
                        if ((b < bg)&& (n < ng)){
                            rndm = 1 + (Math.random() *2).toInt()
                            when(rndm){
                                1-> b++
                                2-> n++
                            }
                        }else{
                            if((b < bg) && (m < mg)){
                                rndm = 1 + (Math.random() * 2).toInt()
                                if (rndm == 2){
                                    rndm = 3
                                }
                                when(rndm){
                                    1-> b++
                                    3-> m++
                                }
                            }else{
                                if ((n < ng) && (m < mg)){
                                    rndm = 2 + (Math.random() * 2).toInt()
                                    when(rndm){
                                        2-> n++
                                        3-> m++
                                    }
                                }else{
                                    if(m < mg){
                                        rndm = 3
                                        m++
                                    }else{
                                        if(n < ng){
                                            rndm = 2
                                            n++
                                        }else{
                                            if(b < bg){
                                                rndm = 1
                                                b++
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                //para cuando toca azul
                1->if (b < bg){
                    b++
                }else{
                    if((r < rg) && (n < ng)&& (m < mg)){
                        rndm = (Math.random()*4).toInt()
                        if(rndm == 1){
                            rndm = 2+ (Math.random()*2).toInt()
                        }
                        when(rndm){
                            0->r++
                            2->n++
                            3->m++
                        }
                    }else{
                        if (r < rg && n < ng){
                            rndm = (Math.random()*2).toInt()
                            if (rndm== 1){
                                rndm = 2
                            }
                            when(rndm){
                                0->r++
                                2->n++
                            }
                        }else{
                            if (r < rg && m < mg){
                                rndm = (Math.random()*2).toInt()
                                if (rndm== 1){
                                    rndm = 3
                                }
                                when(rndm){
                                    0->r++
                                    3->m++
                                }
                            }else{
                                if(n < ng && m < mg){
                                    rndm = 2+(Math.random()*2).toInt()
                                    when(rndm){
                                        2-> n++
                                        3-> m++
                                    }
                                }else{
                                    if (r < rg){
                                        rndm = 0
                                        r++
                                    }else{
                                        if(n < ng){
                                            rndm = 2
                                            n++
                                        }else{
                                            if(m < mg){
                                                rndm = 3
                                                m++
                                            }
                                        }
                                    }
                                }

                            }
                        }
                    }
                }
                //para cuando toca uno normal
                2-> if (n < ng){
                    n++
                }else{
                    if (r < rg && b < bg && m < mg){
                        rndm = (Math.random()*3).toInt()
                        if(rndm == 2){
                            rndm = 3
                        }
                        when(rndm){
                            0->r++
                            1->b++
                            3->m++
                        }
                    }else{
                        if(r < rg && b < bg){
                            rndm =(Math.random()*2).toInt()
                            when(rndm){
                                0->r++
                                1->b++
                            }
                        }else{
                            if(r < rg && m < mg){
                                rndm = (Math.random()*2).toInt()
                                if(rndm == 1){
                                    rndm = 3
                                }
                                when(rndm){
                                    0->r++
                                    3->m++

                                }
                            }else{
                                if(b < bg && m < mg){
                                    rndm = 1+(Math.random()*2).toInt()
                                    if(rndm == 2){
                                        rndm = 3
                                    }
                                    when(rndm){
                                        1->b++
                                        3->m++
                                    }
                                }else{
                                    if(b < bg){
                                        rndm = 1
                                        b++
                                    }else{
                                        if(m < mg){
                                            rndm = 3
                                            m++
                                        }else{
                                            if(r < rg){
                                                rndm = 0
                                                r++
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                //para cuando toca asesino
                3->if (m <1) {
                    m++
                } else{
                    if (r < rg && b < bg && n < ng){
                        rndm = (Math.random()*3).toInt()
                        when(rndm){
                            0->r++
                            1->b++
                            2->n++
                        }
                    }else{
                        if(r< rg && b < bg){
                            rndm = (Math.random()*2).toInt()
                            when(rndm){
                                0->r++
                                1->b++
                            }
                        }else{
                            if(r < rg && n < ng){
                                rndm = (Math.random()*2).toInt()
                                if(rndm == 1){
                                    rndm = 2
                                }
                                when(rndm){
                                    0->r++
                                    2->n++
                                }
                            }else{
                                if(b < bg && n < ng){
                                    rndm = 1+(Math.random()*2).toInt()
                                    when(rndm){
                                        1->b++
                                        2->n++
                                    }
                                }else{
                                    if(r < rg){
                                        rndm = 0
                                        r++
                                    }else{
                                        if(b < bg){
                                            rndm = 1
                                            b++
                                        }else{
                                            if(n < ng){
                                                rndm = 2
                                                n++
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                //Aqui ya se escogio el número

            }
            array += rndm

        }
        cinema += array
    }
    /*for (array in cinema) {
        for (value in array) {
            print("$value ")

        }
        println()
    }

    print("rojo: "+r + "\n" + "azul " + b + "\n"+ "normal "+ n + "\n"+ "asesino " + m)

    print("\n"+"4,3: " + cinema[4][3])*/
    return cinema
}