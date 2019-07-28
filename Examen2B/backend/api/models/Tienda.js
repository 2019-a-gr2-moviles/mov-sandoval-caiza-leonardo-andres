/**
 * Tienda.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombres: {
      type: 'string',
      required: true,
      minLength: 3,
      maxLength: 30,
    },
    direccion: {
      type: 'string',
      required: true,
      minLength: 3,
      maxLength: 30,
    },
    fechaApertura: {
      required: true,
      type: 'string'
    },
    ruc: {
      required: true,
      type: 'number',
      min: 0
    },
    matriz:{      
      required: true,
      type: 'boolean'
    },
    productoDeTienda: {     // Nombre atributo de la relación
      collection: 'producto', // Nombre del modelo a relacionar
      via: 'idTienda'        // Nombre del campo a hacer la relacion
    },
  },

};

