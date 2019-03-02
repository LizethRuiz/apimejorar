'use strict';

/*const  room = require('./models/Room');*/

exports.createroom = (name)=>

    new Promise((resolve,reject)=>{
        const newRoom = new room({
            name : name,
            freespaces : 8,
            created_at: new Date(),
            state: false
        });
        newRoom.save()

        .then(()=>resolve({status:201, message: 'Sala Creada'}))

        .catch(err =>{
            if(err.code == 11000){
                reject({status: 409, message: 'Ya existe una sala con este nombre'});
            }else{
                reject({status: 500, message: 'Error Interno del servidor'});
            }
        })
    })