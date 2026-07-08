# LocalGuide Backend API


Actor: **Customer (Tourist)**, **Provider (Guide)**

---

## UML Class Diagram

![UML Class Diagram](../docs/diagram.png)


---

## Use-Case → Endpoint Mapping

| Use Case | Method | Endpoint |
|---|---|---|
| register() | POST | /tourists |
| login() | POST | /tourists/login |
| updateProfile() | PUT | /tourists/{id} |
| browseTours() | GET | /tour-listings |
| book() | POST | /tours |
| reschedule() | PUT | /tours/{id} |
| cancel() | DELETE | /tours/{id} |
| writeRev() | POST | /reviews |
| editRev() | PUT | /reviews/{id} |
| delRev() | DELETE | /reviews/{id} |

---

## API Endpoints

### 1. Tourist (Customer)

**Create customer profile**
```
POST /tourists
Body: { "name": "Jordan", "email": "jordan@email.com", "password": "pass123" }
```

**Login**
```
POST /tourists/login
Body: { "email": "jordan@email.com", "password": "pass123" }
```

**Modify customer profile**
```
PUT /tourists/{id}
Body: { "name": "Jordan P.", "email": "jordan@email.com", "password": "newpass" }
```

**Get all customers**
```
GET /tourists
```

**Get customer by ID**
```
GET /tourists/{id}
```

---


### 3. Tours (Bookings)

**Book a tour**
```
POST /tours
Body: { "touristId": 1, "serviceId": 2, "name": "Cave Booking", "text": "notes", "location": "Mendip" }
```

**Get all bookings for a tourist**
```
GET /tours/tourist/{touristId}
```

**Get single booking**
```
GET /tours/{id}
```

**Reschedule a booking**
```
PUT /tours/{id}
Body: { "name": "Cave Booking Updated", "text": "new notes", "location": "Mendip" }
```

**Cancel a booking**
```
DELETE /tours/{id}
```

---

### 4. Reviews

**Write a review**
```
POST /reviews
Body: { "touristId": 1, "guideId": 3, "rating": 5, "text": "Amazing tour!" }
```

**Get reviews by tourist**
```
GET /reviews/tourist/{touristId}
```

**Get reviews by guide**
```
GET /reviews/guide/{guideId}
```

**Get single review**
```
GET /reviews/{id}
```

**Edit a review**
```
PUT /reviews/{id}
Body: { "rating": 4, "text": "Updated review text" }
```

**Delete a review**
```
DELETE /reviews/{id}
```
