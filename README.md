# 🛒 Mini E-commerce Backend

![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.11-green?style=flat-square&logo=spring)
![Database](https://img.shields.io/badge/Database-H2-blue?style=flat-square)

Backend RESTful API cho ứng dụng thương mại điện tử, tập trung vào hiệu suất và trải nghiệm người dùng.

## ✨ Tính Năng Nổi Bật

*   📦 **Quản lý Sản phẩm**: Tìm kiếm và phân trang tối ưu.
*   🛒 **Giỏ hàng Thông minh**: Tự động kiểm tra tồn kho (Stock check) trước khi thêm.
*   ⚡ **Hiệu suất cao**: Truy vấn Database được tối ưu hóa, tránh lỗi N+1.
*   🛡️ **Xử lý lỗi**: Cơ chế báo lỗi chi tiết và thân thiện.

## 🛠️ Công Nghệ

| Thành phần | Công nghệ / Thư viện |
| :--- | :--- |
| **Core** | Java 21, Spring Boot 3.5.11 |
| **Database** | H2 (In-memory) |
| **ORM** | Spring Data JPA (Hibernate) |
| **Tiện ích** | Lombok, Maven |

## 🚀 Cài Đặt & Chạy

### 1. Khởi chạy
Bạn có thể chạy ứng dụng ngay lập tức với Maven:

```bash
# Clone dự án
git clone https://github.com/TrungHieu29/mini-ecommerce-be.git

# Chạy ứng dụng
mvn spring-boot:run
```
Server sẽ hoạt động tại: `http://localhost:8080`

### 2. Truy cập Database (H2 Console)
Để kiểm tra dữ liệu, truy cập: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

*   **JDBC URL**: `jdbc:h2:mem:ecommerce-db`
*   **Username**: `sa`
*   **Password**: *(để trống)*

## 📚 API Documentation

### 🛍️ Sản Phẩm (Products)

| Method | Endpoint | Mô tả | Param mẫu |
| :--- | :--- | :--- | :--- |
| `GET` | `/api/products` | Danh sách sản phẩm | `?page=0&size=10` |
| `GET` | `/api/products/{id}` | Chi tiết sản phẩm | |

### 🛒 Giỏ Hàng (Cart)

| Method | Endpoint | Mô tả |
| :--- | :--- | :--- |
| `GET` | `/api/cart/user/{userId}` | Xem giỏ hàng của user(list items + tổng tiền) |
| `POST` | `/api/cart/add` | Thêm sản phẩm vào giỏ |
| `PUT` | `/api/cart/user/{uid}/products/{pid}` | Cập nhật số lượng (`?quantity=5`) |
| `DELETE` | `/api/cart/user/{uid}/products/{pid}` | Xóa sản phẩm khỏi giỏ |

#### 📝 Ví dụ JSON (Thêm vào giỏ)
**URL:** `POST /api/cart/add`

```json
{
  "userId": 1,
  "items": [
    {
      "productId": 101,
      "quantity": 2
    },
    {
      "productId": 105,
      "quantity": 1
    }
  ]
}
```

---
*Project for educational purposes.*
