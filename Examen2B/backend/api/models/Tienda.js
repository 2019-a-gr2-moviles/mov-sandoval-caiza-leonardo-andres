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
    apellidos: {
      type: 'string',
      required: true,
      minLength: 3,
      maxLength: 30,
    },
    fechaNacimiento: {
      required: true,
      type: 'string'
    },
    hijos: {
      required: true,
      type: 'number',
      min: 0
    },
    tieneSeguro:{      
      required: true,
      type: 'boolean'
    },
    productoDeTienda: {     // Nombre atributo de la relación
      collection: 'producto', // Nombre del modelo a relacionar
      via: 'idTienda'        // Nombre del campo a hacer la relacion
    },
  },
};
