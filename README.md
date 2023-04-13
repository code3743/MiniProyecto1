## MiniProyecto 1
### Programación Orientada a Eventos

#### Funciones principales
- Insertar mascota
- Actualizar mascota
- Eliminar mascota
- Buscar mascota por nombre
- Listar todas las mascotas
- Qué mascotas tienen la vacuna malota
- Cual es el top 5 de las mascotas más costosas.
- Que mascotas no tienen país de origen en latinoamérica.

Para tener un listado completo de países, se utilizará la API de [REST COUNTRIES](https://restcountries.com/v3.1/all), la cual nos devuelve información sobre los países. Se construyó un script en Node.js para procesar los datos y generar un archivo JAVA con los países.

### Instrucciones para crear el proyecto en Node.js

Para implementar este proyecto, debes seguir los siguientes pasos:
1. Asegúrate de tener Node.js instalado en tu sistema. Si no lo tienes, descárgalo e instálalo desde el sitio oficial [NodeJs](https://nodejs.org/).
2. Crea un nuevo proyecto en Node.js en tu terminal utilizando el siguiente comando (recomendado crear una carpeta y desde la carpeta ejecutar):
```sh
npm init -y
```
3. Crea un archivo index.js en la raíz de tu proyecto y copia el siguiente código:
```sh
const https = require('https');
const fs = require('fs');
const url = 'https://restcountries.com/v3.1/all';

const toCamelCase = (str)=>{
  const pais = str.normalize("NFD").replace(/[^a-zA-Z0-9]/g, "").split(' ');
  let paisModificado = '';
  for (let i = 0; i < pais.length; i++) {
    paisModificado += pais[i].replace(pais[i][0], pais[i][0].toUpperCase());
  }
return paisModificado.replace(/\s/g, '');
}

https.get(url, (res) => {
  let data = '';
  res.on('data', (chunk) => {
    data += chunk;
  });

  res.on('end', () => {
    const countries = JSON.parse(data);
    const enumValues = countries.map((country) => {
      const name = toCamelCase(country.translations.spa.common);
      return name;
    });

    const enumString = `public enum Paises {\n${enumValues.map((value) => `  ${value},\n`).join('')}}`;

    fs.writeFile('Paises.java', enumString, (err) => {
      if (err) throw err;
      console.log('Archivo Paises.java generado correctamente.');
    });
  });
}).on('error', (err) => {
  console.error('Error al consumir la API: ', err.message);
});
```
4. Ejecuta el siguiente comando y esperar que el script diga **Archivo Paises.java generado correctamente.**
```sh
node index.js
```
5. En el directorio del proyecto se genera un archivo Paises.java el cual tiene los el nombre de 250 paises sin acento ni espacios como: Puerto Rico -> PuertoRico