# Dynamic UI Prototype (Kotlin/Compose/CLEAN)

## Quick Start

1. Place all generated files in your project root (run this script from the root).
2. Add these dependencies to your `app/build.gradle`:
    - androidx.activity:activity-compose
    - androidx.compose.ui:ui
    - androidx.compose.material3:material3
    - androidx.lifecycle:lifecycle-runtime-ktx
    - androidx.lifecycle:lifecycle-viewmodel-compose
    - org.jetbrains.kotlinx:kotlinx-serialization-json
    - io.coil-kt:coil-compose
3. Sync Gradle and run the app!

The UI is fully dynamic, driven from assets/dynamic_ui_config.json and mock_data.json, following CLEAN architecture.
