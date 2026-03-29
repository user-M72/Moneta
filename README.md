# 💰 Cashflow — Personal Finance REST API

![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.x-green?style=flat-square&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue?style=flat-square&logo=postgresql)
![Docker](https://img.shields.io/badge/Docker-ready-blue?style=flat-square&logo=docker)

Приложение для управления личными финансами. Пользователь задаёт бюджет на месяц, фиксирует расходы и доходы по категориям, и получает статистику по месяцам и годам.

---

## ✨ Возможности

- 📅 **Месячный бюджет** — установить лимит на текущий месяц
- 💸 **Транзакции** — добавлять расходы и доходы с категорией и заметкой
- 📊 **Статистика** — аналитика по месяцам и по годам
- 🏷 **Категории** — управление категориями с иконкой и цветом
- 🗑 **Soft delete** — данные не удаляются, а помечаются как удалённые
- ⚠️ **Валидация** — проверка данных на уровне entity и сервиса

---

## 🛠 Стек технологий

| Категория | Технология |
|-----------|-----------|
| Язык | Java 17 |
| Фреймворк | Spring Boot 3 |
| База данных | PostgreSQL 15 |
| ORM | Spring Data JPA / Hibernate |
| Валидация | Jakarta Validation |
| Сборка | Gradle |
| Контейнеризация | Docker |

---

## 🚀 Быстрый старт

### Требования

- Java 17+
- Maven 3.9+
- Docker & Docker Compose (рекомендуется)
- PostgreSQL (если запускать локально)

### Запуск через Docker (рекомендуется)

```bash
# Клонировать репозиторий
git clone https://gitlab.com/yourname/cashflow.git
cd cashflow

# Запустить
docker-compose up --build
```

Приложение будет доступно по адресу: `http://localhost:8080`

### Запуск локально

```bash
# Клонировать репозиторий
git clone https://gitlab.com/yourname/cashflow.git
cd cashflow

# Настроить базу данных в src/main/resources/application.yml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/cashflow
    username: your_username
    password: your_password

# Запустить
mvn spring-boot:run
```

---

## 📡 API Endpoints

### 👤 Пользователи
| Метод | URL | Описание |
|-------|-----|----------|
| POST | `/api/users/v1/register` | Создать пользователя |
| GET | `/api/users/v1/{id}` | Получить пользователя |
| PUT | `/api/users/v1/{id}` | Обновить пользователя |
| DELETE | `/api/users/v1/{id}` | Удалить пользователя |

### 🏷 Категории
| Метод | URL | Описание |
|-------|-----|----------|
| GET | `/api/categories/v1` | Получить все категории |
| POST | `/api/categories/v1` | Создать категорию |
| PUT | `/api/categories/v1/{id}` | Обновить категорию |
| DELETE | `/api/categories/v1/{id}` | Удалить категорию |

### 📅 Бюджет
| Метод | URL | Описание |
|-------|-----|----------|
| GET | `/api/budgets/v1` | Получить все бюджеты |
| GET | `/api/budgets/v1/{year}/{month}` | Бюджет за конкретный месяц |
| POST | `/api/budgets/v1` | Создать бюджет |
| PUT | `/api/budgets/v1/{id}` | Обновить бюджет |

### 💸 Транзакции
| Метод | URL | Описание |
|-------|-----|----------|
| GET | `/api/transactions/v1` | Получить все транзакции |
| GET | `/api/transactions/v1/{id}` | Получить по ID |
| POST | `/api/transactions/v1` | Добавить транзакцию |
| PUT | `/api/transactions/v1/{id}` | Обновить транзакцию |
| DELETE | `/api/transactions/v1/{id}` | Удалить транзакцию |

### 📊 Статистика
| Метод | URL | Описание |
|-------|-----|----------|
| GET | `/api/stats/v1/month/{year}/{month}` | Статистика за месяц |
| GET | `/api/stats/v1/year/{year}` | Статистика за год |
| GET | `/api/stats/v1/categories/{year}/{month}` | Расходы по категориям |

---

## 🏗 Структура проекта

```
cashflow/
├── src/
│   └── main/java/uz/yourname/cashflow/
│       ├── config/          # Конфигурации
│       ├── controller/      # REST контроллеры
│       ├── dto/             # Объекты передачи данных
│       │   ├── req/
│       │   └── res/
│       ├── entity/          # JPA entity классы
│       ├── exception/       # Кастомные исключения
│       ├── mapper/          # Маперы
│       ├── repository/      # Spring Data репозитории
│       └── service/         # Бизнес-логика
├── Dockerfile
├── docker-compose.yml
├── pom.xml
└── README.md
```

---

## 🗄 Структура entity

```
BaseEntity         ← общий родитель (id, createdAt, updatedAt, deleted)
├── User           ← пользователь (имя, валюта)
├── Category       ← категория транзакций (Еда, Транспорт и т.д.)
├── MonthBudget    ← бюджет на конкретный месяц
└── Transaction    ← одна запись дохода или расхода
```

### Связи

- `User` → `Category` (один ко многим)
- `User` → `MonthBudget` (один ко многим)
- `MonthBudget` → `Transaction` (один ко многим)
- `Category` → `Transaction` (один ко многим)

---

## 🔧 Переменные окружения

| Переменная | Описание | Пример |
|---|---|---|
| `SPRING_DATASOURCE_URL` | URL базы данных | `jdbc:postgresql://localhost:5432/cashflow` |
| `SPRING_DATASOURCE_USERNAME` | Пользователь БД | `postgres` |
| `SPRING_DATASOURCE_PASSWORD` | Пароль БД | `secret` |
| `SERVER_PORT` | Порт приложения | `8080` |

---

## 👤 Автор

**Ваше имя**
GitLab: [@yourname](https://gitlab.com/user-M72)
Project: [Cashflow](https://gitlab.com/user-M72/cashflow)

---

## 📄 License

MIT License
