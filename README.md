# QR-Code Generator
- RestAPI to generate and manage Base64 QR Barcode.

# How to run the app

## Prerequisites
- Docker installed and running
- Java 17 or Higher

## How to run it
- Clone this repository to your local machine.
- once the repository is on your local machine. Go to the project folder and run `docker-compose up`. This will generate the MySQL database where the QR details will be stored and start the container automatically.
- Finally, run the program. Make sure to have your MySQL container running. You can run it using the .jar file or your local IDE.

# How to use it
- Once the Spring Boot application and the Docker container is running, you can access the main route on `http://localhost:8080/qrcode`.

## Endpoints

### GET /qrcode -> Retrieve all the QR Codes found on the database 
```json
[
  {
    "id": "Return UUID",
    "product_name": "Return String",
    "product_price": Return double,
    "description": "Return String",
    "retailer": "Return String",
    "url": "Returns the url string to convert to Base64 string",
    "qr_code": "Returns a Base64 string"
  }
]
```
- Note: some of the fields can be removed and/or modified on the QR Class
```
@Entity
public class QR {
	
	@Id
	@GeneratedValue
	private UUID id;
	private String product_name;
	private double product_price;
	private String description;
	private String retailer;
	private String url;
	@Transient
	private byte[] qr_code;
	
	public QR() {
		
	}

	public QR(UUID id, String product_name, double product_price, String description, String retailer, String url,
			byte[] qr_code) {
		super();
		this.id = id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.description = description;
		this.retailer = retailer;
		this.url = url;
		this.qr_code = qr_code;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public double getProduct_price() {
		return product_price;
	}

	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRetailer() {
		return retailer;
	}

	public void setRetailer(String retailer) {
		this.retailer = retailer;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public byte[] getQr_code() {
		return qr_code;
	}

	public void setQr_code(byte[] qr_code) {
		this.qr_code = qr_code;
	}
	
}
```
Change any field(Except for UUID and qr_code) to anything you would like your API to store.

### POST /qrcode -> Add new QR Object to the API 
```json
[
  {
    "id": "Return UUID",
    "product_name": "Return String",
    "product_price": Return double,
    "description": "Return String",
    "retailer": "Return String",
    "url": "Returns the url string to convert to Base64 string",
    "qr_code": "Returns a Base64 string"
  }
]
```
### GET /qrcode/{id} -> Returns QR Object of specified id
```json
[
  {
    "id": "Return UUID",
    "product_name": "Return String",
    "product_price": Return double,
    "description": "Return String",
    "retailer": "Return String",
    "url": "Returns the url string to convert to Base64 string",
    "qr_code": "Returns a Base64 string"
  }
]
```

### PUT /qrcode/{id} -> Updates/Modifies any defined field of the specified QR Object

### DELETE /qrcode/{id} -> Deletes QR object of specified id





  
