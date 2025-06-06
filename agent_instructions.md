# Dynamic UI Project: Clean Architecture Example

## Project Overview

This project demonstrates how to build a dynamic, scalable UI (like an invoice/catalog app) using a JSON configuration and mock data. It follows CLEAN architecture principles to separate concerns between UI, business logic, and data.

The UI is defined using a JSON schema, allowing for flexible layout changes without code modifications. Business logic (use cases, repositories) is decoupled and can be easily extended or swapped.

## Folder Structure

```
/app
  /src/main/assets/
    dynamic_ui_config.json     # UI layout and component config
    mock_data.json            # Product and tab mock data

/domain
  /model/
    Product.kt
    Tab.kt
  /repository/
    ProductRepository.kt
  /usecase/
    GetProductsListUseCase.kt
    FilterProductsByTabUseCase.kt
    AddProductToCartUseCase.kt
    NavigateToCartUseCase.kt

/data
  /repository/
    ProductRepositoryImpl.kt

/presentation
  /viewmodel/
    DynamicUiViewModel.kt
  /ui/
    DynamicUIScreen.kt
```

## How it Works

1. **UI Configuration**
   - The layout and components (top bar, tab bar, product list, cart button) are described in `dynamic_ui_config.json` using columns and rows for scalable, dynamic rendering.

2. **Mock Data**
   - Product and tab data are stored in `mock_data.json` for demonstration, and can be replaced by real data sources.

3. **Domain Models**
   - `Product.kt` and `Tab.kt` define the data structures for products and tabs.

4. **Repository Layer**
   - `ProductRepository.kt` defines the contract for fetching product data.
   - `ProductRepositoryImpl.kt` provides a mock implementation using the mock data.

5. **Business Logic (Use Cases)**
   - `GetProductsListUseCase.kt` retrieves all products.
   - `FilterProductsByTabUseCase.kt` filters products based on the selected tab/category.
   - `AddProductToCartUseCase.kt` handles adding a product to the cart (stub provided).
   - `NavigateToCartUseCase.kt` handles navigation logic (stub provided).

6. **ViewModel**
   - `DynamicUiViewModel.kt` observes UI state, executes use cases, and exposes data to the UI.

7. **Dynamic UI Rendering**
   - `DynamicUIScreen.kt` reads the JSON config, renders UI components dynamically, and binds product/tab data from the ViewModel.

## Usage Instructions

1. **Place the files**
   - Add the provided JSON files to `/app/src/main/assets/`.
   - Place the Kotlin class files in their respective domains.

2. **Implement the UI**
   - Use Jetpack Compose or your preferred UI toolkit.
   - Parse `dynamic_ui_config.json` at runtime to render the UI dynamically.
   - Bind product and tab data from the ViewModel.

3. **Hook up business logic**
   - Inject use cases and repositories into the ViewModel.
   - Connect UI event handlers (tab selection, product clicks, cart button) to their corresponding use cases.

4. **Run & Test**
   - Build and run the app. The UI will adapt based on the JSON config and display product data.
   - You can modify the JSON layout/config and mock data to change the UI or demo different scenarios without code changes.

## Extending the Project

- To add new UI features, update the JSON config and implement any required new business logic/use cases.
- For real data, implement the repository to fetch from a network or database.
- Expand `AddProductToCartUseCase` and `NavigateToCartUseCase` as needed for full cart functionality and navigation.

## Design Principles

- **CLEAN Architecture**: Clear separation between UI, business logic, and data.
- **Scalable Layout**: Using Column/Row structure in the JSON config for flexible, future-proof UI.
- **Performance & Readability**: Optimized for easy reading, extension, and efficient updates.

---

This setup enables Copilot agents or developers to rapidly build, modify, and extend a dynamic UI app with minimal code changes and maximum maintainability.