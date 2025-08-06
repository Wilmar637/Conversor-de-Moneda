# 💱 Conversor de Moneda

Aplicación de consola desarrollada en **Java 17** con arquitectura **MVC (Modelo-Vista-Controlador)**. Permite convertir montos entre distintas monedas utilizando la API de [ExchangeRate-API](https://www.exchangerate-api.com/) y guardar los resultados en formato `.json`.

---

## 🧠 Características

- Conversión de monedas:
  - USD ⇄ ARS
  - USD ⇄ BRL
  - USD ⇄ COP
- Arquitectura limpia basada en MVC
- Manejo de errores al consultar la API
- Serialización de resultados en archivos JSON
- Código documentado y fácil de extender

---

## 🗂️ Estructura del Proyecto

ConversorDeMonedas/
│
├── src/
│ ├── controlador/ # Lógica de control (ConversorControlador)
│ ├── modelo/ # Clases de dominio (Moneda, ConsultaMoneda)
│ ├── util/ # Utilidades (GeneradorDeArchivo)
│ └── vista/ # Interfaz (Main / Principal)
│
├── .gitignore
├── README.md
└── ConversorDeMonedas.iml


---

## 📦 Requisitos

- Java 17 o superior
- Acceso a internet (para consumo de la API)
- [Gson 2.10.1](https://github.com/google/gson) para manejo de JSON

---

## ▶️ Ejecución

Puedes compilar y ejecutar desde la terminal o usar **IntelliJ IDEA**:
'''bash
cd src
javac vista/Principal.java
java vista.Principal

---

## Ejemplo de Salida
********** Bienvenido/a al Conversor de Moneda **********

1. Dólar => Peso Argentino
2. Peso Argentino => Dólar
...
Seleccione Opción:
5
Ingrese el valor en USD: 1
El valor 1,00 [USD] corresponde a = 4128,18 [COP]
Archivo guardado como: conversion_USD_a_COP.json

---

👨‍💻 Autor
Wilmar Diaz
GitHub: Wilmar637
