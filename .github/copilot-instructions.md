# Project: Zakya Android App

## Language & Framework
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose (Material 3)
- **Architecture**: CLEAN Architecture
- **Min SDK**: 24
- **Target**: Phone + Tablet (both orientations)

## Code Conventions
- Follow Kotlin coding conventions (ktlint)
- Use `@Composable` functions, not XML layouts
- Use `remember` and `mutableStateOf` for local UI state
- Use `WindowSizeClass` for responsive layouts (compact/medium/expanded)
- Prefer `Modifier` chaining over nested layouts
- Use `dp` for spacing/sizing, `sp` for text
- Function names: PascalCase for Composables, camelCase for others

## Design System: ZakyaColors
- Colors are defined in `com.gofrugal.library.common.ZakyaColors`
- Two themes exist: `RetailColors` (blue accent #5D92F8) and `RestaurantColors` (green accent #14AB6E)
- ALWAYS use ZakyaColors tokens over hardcoded Color() values where a matching token exists
- Access via the app's theme/color provider (e.g., `zakyaColors.colorAccent`)

### Key Color Mappings (RestaurantColors)
| Hex | ZakyaColors Token |
|-----|-------------------|
| #14AB6E | colorAccent, colorControlActivated, focusedIndicator |
| #D23E3F | error, errorBackground |
| #09090A | darkGrey900 |
| #EAEEF2 | bottomBarDividerColor |
| #DAE2EA | unfocusedIndicator |
| #FFFFFF | white |
| #000000 | black |

### Key Color Mappings (RetailColors)
| Hex | ZakyaColors Token |
|-----|-------------------|
| #5D92F8 | colorAccent, defaultAccentColor, progressColor |
| #263042 | colorPrimary |
| #E93323 | error, errorBackground |

## Fonts
- Primary font: Inter (loaded from resources: `R.font.font_inter_medium`, `R.font.font_inter_semibold`)
- SF Pro / SF Pro Text in Figma designs → map to `FontFamily.Default` on Android (closest native equivalent)

## Project Structure
```
ui/screens/{ScreenName}Screen.kt
ui/components/{ComponentName}.kt
ui/theme/Colors.kt (ZakyaColors)
```

## Performance
- Use `LazyColumn`/`LazyRow` for lists
- Use `remember` to avoid recomposition of expensive calculations
- Prefer `Modifier.drawBehind` over `Box` with background for performance-critical paths

## Responsive Design
- Compact (phone portrait): 360-412dp — fill width, 16dp margin
- Medium (phone landscape / small tablet): 600-840dp — fill width, 24dp margin
- Expanded (tablet): 840dp+ — max-width constrained, centered
- ALWAYS test both portrait and landscape
- Use `verticalScroll()` when content may overflow in portrait
