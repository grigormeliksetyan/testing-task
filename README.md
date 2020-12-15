## Demo Challenge

#### Project Setup

1. Clone this project.
2. Setup the project in your IDE.
3. Open the index.html file from src/test/resource/files in a browser
4. Copy the url from the browser and update the url value in src/test/resource/config.properties to
   be the copied url.
5. In src/test/resources update the config.properties file platform for your OS.
6. From command line run mvn clean install -U -DskipTests
7. Make sure you can run the DemoTest and chrome launches. You may need to update the chromedriver
   in /src/test/resources/chromedriver/ to the version that works with your browser
   https://chromedriver.chromium.org/

#### Technologies

1. Java
2. Selenium
3. TestNG
4. Any other technologies you see fit.
5. Please do not use a BDD framework.

#### Expectations

We will be evaluating

1. Quality of test cases
2. Variety of testing types (examples: boundary, happy path, negative, etc)
3. Code structure and organization
4. Naming conventions
5. Code readability
6. Code modularity

#### Exercise

1. Use the site at the index.html
2. There are helper locators provided for you in the src/test/resource/files/locators.txt file.
3. In the Read me file, write up all of the test cases you think are necessary to test the sample
   page. Please note any defects or issues observed in the Read me file.
4. Code up a few examples of

- At least one happy path case placing an order
- At least one error case

5. When complete please check your code into a public git repo

#### Test Cases

1. Open page
2. Validate a layout, field names
3. Validate page title
4. Make sure that all required fields are marked with * symbol

1. Chose any "Pizza 1", "Toppings 1", "Toppings 2"
2. Fill any valid quantity
3. Make sure appropriate cost is generated in the "cost" field, and it is read only
4. Change quantity with other value
5. Make sure appropriate cost is generated in the "cost" field, and it is read only

1. Fill all the fields with any values
2. Click reset button
3. Make sure all the fields has been reset to default state

1. Chose any "Pizza 1", "Toppings 1", "Toppings 2"
2. Fill any valid quantity
3. Fill any valid name, email and phone
4. Set "Credit Card" as payment method
5. Click "Place Order" button
6. Make sure popup appeared with message "Thank you for your order! TOTAL: " + appropriate cost and
   product name. E.g. Thank you for your order! TOTAL: 6.75 Small 6 Slices - no toppings
7. Make sure the appropriate amount of money has been withdrawn from your card

1. Chose any "Pizza 1", "Toppings 1", "Toppings 2"
2. Fill any valid quantity
3. Fill any valid name, email and phone
4. Set "Cash on Pickup" as payment method
5. Click "Place Order" button
6. Make sure popup appeared with message "Thank you for your order! TOTAL: " + appropriate cost and
   product name. E.g. Thank you for your order! TOTAL: 6.75 Small 6 Slices - no toppings

1. Unset/clear all the fields
2. Click "Place Order" button
3. Make sure all the validations appeared in popup windows for required fields - "Pizza 1", "
   Quantity", "Name", "Phone" and "Payment Information"

1. Chose any "Pizza 1", "Toppings 1", "Toppings 2"
2. Fill quantity 0
3. Fill all the other required fields with valid values
4. Click "Place Order" button
5. Make sure there's validation about invalid quantity in the popup window appeared

1. Chose any "Pizza 1", "Toppings 1", "Toppings 2"
2. Fill "Quantity" maximum quantity + 1
3. Fill all the other required fields with valid values
4. Click "Place Order" button
5. Make sure there's validation about invalid quantity in the popup window appeared

1. Fill all the required fields with any valid values except "Name", "Email" and "Phone"
2. Fill "Name", "Email" and "Phone" fields with the maximum length, try to fill more
3. Make sure there's restriction, and it's cutting the characters that above the maximum amount

1. Fill all the required fields with any valid values except "Email"
2. Fill invalid format email
3. Click "Place Order" button
4. Make sure the validation appears about invalid email

1. Fill all the required fields with any valid values except "Name" and "Phone"
2. Fill name and phone using all type of characters - alphanumeric, special symbols
3. Click "Place Order" button
4. Make sure the order processed successfully and popup appeared with message "Thank you for your
   order! TOTAL: " + appropriate cost and product name. E.g. Thank you for your order! TOTAL: 6.75
   Small 6 Slices - no toppings

