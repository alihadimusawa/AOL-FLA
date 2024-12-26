package model;

import java.time.LocalDate;

public class Transaction {

	   private String id;
	    private LocalDate date;
	    private String description;
	    private double amount;
	    private String category;

		LocalDate currentDate = LocalDate.now();


	    public Transaction(String id, String description, double amount, String category) {
	        this.id = id;
	        this.date = currentDate.now();
	        this.description = description;
	        this.amount = amount;
	        this.category = category;
	    }

	 // Getters and setters for all fields
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public LocalDate getDate() {
			return date;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

	    // Additional methods based on your requirements
	}

