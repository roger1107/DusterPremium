# Duster Premium

Launcher Android en formato horizontal, diseñado para pantalla 1024×600 y unidades Android de automóvil.

## Compilar
El repositorio incluye GitHub Actions. En GitHub abre **Actions** y ejecuta **Build Duster Premium APK** (o espera a que termine el flujo disparado por un push). Descarga el artefacto **DusterPremium-APK** y dentro encontrarás `app-debug.apk`.

## Instalar
Instala el APK en la unidad Android. Para usarlo como launcher, pulsa Home y selecciona **Duster Premium** como aplicación de inicio.

## Compatibilidad y límites
- Diseñado para Android 10 y pantallas horizontales 1024×600; minSdk 23.
- Los botones abren Maps, Spotify (o YouTube Music si Spotify no está instalado), ajustes Bluetooth y ajustes Android.
- Radio FM muestra un aviso para abrir la app de radio incluida en la unidad. No controla el sintonizador directamente.
- El mapa es una tarjeta visual; la navegación real se abre en Google Maps.
- No controla climatización, CAN bus, sensores del vehículo ni Android Auto. Esas funciones requieren integración específica del fabricante/unidad.
- El vehículo ilustrado es un gráfico SVG estilizado, no una fotografía.
