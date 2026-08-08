# CP353201 Software Quality Assurance (SQA)
## Lab 6: Decision Table Testing

**ผู้จัดทำ:**
* **ชื่อ-นามสกุล:** นางสาวสโรชา เสาทอง
* **รหัสนักศึกษา:** 673380296-7
* **สาขาวิชา:** วิทยาการคอมพิวเตอร์ วิทยาลัยการคอมพิวเตอร์ มหาวิทยาลัยขอนแก่น

---

## 📌 วัตถุประสงค์ของปฏิบัติการ
1. เพื่อออกแบบและอธิบายกรณีทดสอบ (Test Cases) ระดับ Unit Testing สำหรับคลาส `QuadraticEquation`
2. เพื่อประยุกต์ใช้เทคนิค **Limited Entry Decision Table (LEDT)** ในการออกแบบกรณีทดสอบ (Lab 6.1)
3. เพื่อประยุกต์ใช้เทคนิค **Extended Entry Decision Table (EEDT)** ในการออกแบบกรณีทดสอบ (Lab 6.2)
4. เพื่อเขียนระบบทดสอบอัตโนมัติด้วย **JUnit 5 (`@ParameterizedTest`)** ร่วมกับ `@CsvSource`
5. เพื่อบันทึกและสรุปผลการทดสอบลงใน Excel Template ตามข้อกำหนด

---

## 📂 โครงสร้างโปรเจกต์ (Project Structure)

```text
Lab6_DT/
├── src/
│   ├── main/java/com/example/
│   │   ├── QuadraticEquation.java      # Class หลักในการคำนวณสมการกำลังสอง
│   │   ├── RootNature.java             # Enum ระบุชนิดของคำตอบ (NOT_QUADRATIC, REAL_ROOTS, ฯลฯ)
│   │   └── RootResult.java             # Class จัดเก็บค่าคำตอบของสมการ
│   └── test/java/com/example/
│       ├── QuadraticEquationLab6_1Test.java  # Unit Test สำหรับ Lab 6.1 (LEDT)
│       └── QuadraticEquationLab6_2Test.java  # Unit Test สำหรับ Lab 6.2 (EEDT)
├── Lab6_TestCases_Design.xlsx          # ไฟล์บันทึกตาราง Decision Table และผลการทดสอบ
├── pom.xml                             # Maven Dependencies (JUnit 5 / Parameterized Test)
└── README.md                           # อธิบายรายละเอียดโปรเจกต์
