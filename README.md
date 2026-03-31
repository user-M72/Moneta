# 💰 Moneta — Personal Finance REST API

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green?style=flat-square&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue?style=flat-square&logo=postgresql)
![Gradle](https://img.shields.io/badge/Gradle-8-02303A?style=flat-square&logo=gradle)
![Docker](https://img.shields.io/badge/Docker-ready-2496ED?style=flat-square&logo=docker)
![License](https://img.shields.io/badge/License-MIT-yellow?style=flat-square)

Приложение для управления личными финансами. Пользователь задаёт бюджет на месяц, записывает расходы и доходы по категориям, и в конце месяца видит сколько потрачено и сколько осталось.

---

## ✨ Возможности

- 📅 **Месячный бюджет** — установить лимит расходов на текущий месяц
- 💸 **Записи** — фиксировать расходы и доходы с категорией, суммой и заметкой
- 📊 **Итог месяца** — сколько потрачено, сколько получено, сколько осталось
- 🏷 **Категории** — создавать свои категории с иконкой и цветом
- 🔐 **Роли** — разграничение прав `ROLE_USER` / `ROLE_ADMIN`
- 🗑 **Soft delete** — данные помечаются как удалённые, история сохраняется
- ✅ **Валидация** — проверка входных данных на уровне entity и сервиса
- ⚠️ **Обработка ошибок** — единый формат ошибок через global exception handler

---

## 🛠 Стек технологий

| Категория | Технология |
|-----------|-----------|
| Язык | Java 17 |
| Фреймворк | Spring Boot 3 |
| Безопасность | Spring Security + JWT |
| База данных | PostgreSQL 15 |
| ORM | Spring Data JPA / Hibernate |
| Валидация | Jakarta Validation |
| Аудит | Spring Data JPA Auditing |
| Сборка | Gradle |
| Контейнеризация | Docker & Docker Compose |

---

## 🗄 Структура entity

```
BaseDomain         ← общий родитель (id · createdBy · createdDate · updatedBy · updatedDate)
├── User           ← пользователь (firstName, lastName, username, email, password, roles)
├── Role           ← роль пользователя (ROLE_USER / ROLE_ADMIN)
├── Category       ← категория записей (name, icon, color, type, deleted)
├── MonthBudget    ← бюджет на месяц (year, month, totalAmount, deleted)
└── Transaction    ← запись расхода или дохода (amount, note, date, type, deleted)
```

**Связи:**
- `User` → `Role` (многие ко многим, через `users_roles`)
- `User` → `Category` (один ко многим)
- `User` → `MonthBudget` (один ко многим)
- `MonthBudget` → `Transaction` (один ко многим)
- `Category` → `Transaction` (один ко многим)

---

## 📡 API Endpoints

### 🔐 Auth
| Метод | URL | Описание |
|-------|-----|----------|
| `POST` | `/api/auth/v1/register` | Регистрация |
| `POST` | `/api/auth/v1/login` | Вход и получение токена |

### 👤 Пользователи
| Метод | URL | Описание | Доступ |
|-------|-----|----------|--------|
| `GET` | `/api/users/v1/{id}` | Получить пользователя | USER |
| `PUT` | `/api/users/v1/{id}` | Обновить пользователя | USER |
| `DELETE` | `/api/users/v1/{id}` | Удалить пользователя | ADMIN |

### 🏷 Категории
| Метод | URL | Описание | Доступ |
|-------|-----|----------|--------|
| `GET` | `/api/categories/v1` | Получить все категории | USER |
| `POST` | `/api/categories/v1` | Создать категорию | USER |
| `PUT` | `/api/categories/v1/{id}` | Обновить категорию | USER |
| `DELETE` | `/api/categories/v1/{id}` | Удалить категорию | USER |

### 📅 Бюджет
| Метод | URL | Описание | Доступ |
|-------|-----|----------|--------|
| `GET` | `/api/budgets/v1` | Все бюджеты | USER |
| `GET` | `/api/budgets/v1/{year}/{month}` | Бюджет за месяц | USER |
| `POST` | `/api/budgets/v1` | Создать бюджет | USER |
| `PUT` | `/api/budgets/v1/{id}` | Обновить бюджет | USER |

### 💸 Транзакции
| Метод | URL | Описание | Доступ |
|-------|-----|----------|--------|
| `GET` | `/api/transactions/v1` | Все записи | USER |
| `GET` | `/api/transactions/v1/{id}` | Запись по ID | USER |
| `POST` | `/api/transactions/v1` | Добавить запись | USER |
| `PUT` | `/api/transactions/v1/{id}` | Обновить запись | USER |
| `DELETE` | `/api/transactions/v1/{id}` | Удалить запись | USER |

### 📊 Статистика
| Метод | URL | Описание | Доступ |
|-------|-----|----------|--------|
| `GET` | `/api/stats/v1/month/{year}/{month}` | Итог за месяц | USER |
| `GET` | `/api/stats/v1/year/{year}` | Итог за год | USER |
| `GET` | `/api/stats/v1/categories/{year}/{month}` | Расходы по категориям | USER |

---

## 🚀 Быстрый старт

### Требования

- Java 17+
- Gradle 8+
- Docker & Docker Compose (рекомендуется)
- PostgreSQL (если запускать локально)

### Запуск через Docker (рекомендуется)

```bash
git clone https://github.com/user-M72/Moneta.git
cd Moneta
docker-compose up --build
```

Приложение: `http://localhost:8080`

### Запуск локально

```bash
git clone https://github.com/user-M72/Moneta.git
cd Moneta

# Настроить src/main/resources/application.yml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/moneta
    username: your_username
    password: your_password

./gradlew bootRun
```

---

## 🔧 Переменные окружения

| Переменная | Описание | Пример |
|---|---|---|
| `SPRING_DATASOURCE_URL` | URL базы данных | `jdbc:postgresql://localhost:5432/moneta` |
| `SPRING_DATASOURCE_USERNAME` | Пользователь БД | `postgres` |
| `SPRING_DATASOURCE_PASSWORD` | Пароль БД | `secret` |
| `JWT_SECRET` | Секретный ключ для JWT | `your-secret-key` |
| `SERVER_PORT` | Порт приложения | `8080` |

---

## 🏗 Структура проекта

```
Moneta/
├── src/
│   └── main/java/Moneta/cashflow/
│       ├── config/          # Spring Security, JWT, Audit конфигурации
│       ├── controller/      # REST контроллеры
│       ├── dto/             # Объекты передачи данных
│       │   ├── req/         # Request DTO
│       │   └── res/         # Response DTO
│       ├── entity/          # JPA entity классы
│       │   ├── baseDomain/  # BaseDomain (общий родитель)
│       │   └── EnumStatus/  # TransactionType, RoleName
│       ├── exception/       # Кастомные исключения и global handler
│       ├── mapper/          # Маперы (entity ↔ DTO)
│       ├── repository/      # Spring Data репозитории
│       └── service/         # Бизнес-логика
├── Dockerfile
├── docker-compose.yml
├── build.gradle
└── README.md
```

---

## 👤 Автор

**Muzaffar**
GitHub: [@user-M72](https://github.com/user-M72)
Project: [Moneta](https://github.com/user-M72/Moneta)

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).
