# 🧾 Sales Management System - Spring Boot

This project is an **academic system** developed for educational purposes.  
It is a **Sales Management System** built with **Java** and **Spring Boot**, designed to manage **Clients**, **Employees**, **Products**, **People**, and **Sales** through a simple web interface using **Thymeleaf** and **Spring Data JPA** for database persistence.

---

## 🎯 Project Purpose

> 📚 This is an **academic project**, developed as part of a learning experience in **Java Web Development with Spring Boot**.  
> It focuses on understanding **MVC architecture**, **dependency injection**, and **CRUD operations** using **Spring Framework**.

---

## 🚀 Technologies Used

- **Java 17+**
- **Spring Boot**
- **Spring MVC**
- **Spring Data JPA**
- **Thymeleaf**
- **PostgreSQL** (or another database)
- **Maven**

---

## 🧩 Controllers Overview

### 🧍 ClienteController
**Base Path:** `/clientes`

- `GET /clientes` → Displays all clients.  
- `GET /clientes/novo` → Shows the registration form.  
- `GET /clientes/editar/{id}` → Shows the edit form.  
- `POST /clientes/salvar` → Saves or updates a client record.

---

### 👨‍💼 FuncionarioController
**Base Path:** `/funcionarios`

- `GET /funcionarios` → Lists all employees.  
- `GET /funcionarios/novo` → Displays the registration form.  
- `GET /funcionarios/editar/{id}` → Displays the edit form.  
- `POST /funcionarios/salvar` → Saves or updates an employee.

---

### 👥 PessoaController
**Base Path:** `/pessoas`

- `GET /pessoas` → Lists all people in the system.

---

### 📦 ProdutoController
**Base Path:** `/produtos`

- `GET /produtos` → Lists all products.  
- `GET /produtos/novo` → Displays the product registration form.  
- `GET /produtos/editar/{id}` → Displays the product edit form.  
- `POST /produtos/salvar` → Creates or updates a product record.

---

### 💰 VendaController
**Base Path:** `/vendas`

- `GET /vendas` → Lists all sales.  
- `GET /vendas/nova` → Shows the form to create a new sale.  
- `POST /vendas/salvar` → Processes and saves a sale.

**This controller interacts with:**
- `VendaService` – Business logic for processing sales.  
- **Repositories:** `VendaRepository`, `ProdutoRepository`, `ClienteRepository`, `FuncionarioRepository`.
