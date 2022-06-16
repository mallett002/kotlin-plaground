package collections

// Find all the different cities the customers are from
fun Shop.getCustomerCities(): Set<City> =
    customers.map { it.city }.toSet()

// Find the customers living in a given city
fun Shop.getCustomersFrom(city: City): List<Customer> =
    customers.filter { it.city.equals(city) }

// Return true if all customers are from a given city
fun Shop.checkAllCustomersAreFrom(city: City): Boolean =
    customers.all{ it.city.equals(city) }

// Return true if there is at least one customer from a given city
fun Shop.hasCustomerFrom(city: City): Boolean =
    customers.any{ it.city.equals(city) }

// Return the number of customers from a given city
fun Shop.countCustomersFrom(city: City): Int =
    customers.count{ it.city.equals(city) }

// Return a customer who lives in a given city, or null if there is none
fun Shop.findCustomerFrom(city: City): Customer? =
    customers.firstOrNull{ it.city.equals(city) }

// Build a map from the customer name to the customer
fun Shop.nameToCustomerMap(): Map<String, Customer> =
    customers.associateBy(Customer::name)

// Build a map from the customer to their city
fun Shop.customerToCityMap(): Map<Customer, City> =
    customers.associateWith(Customer::city)

// Build a map from the customer name to their city
fun Shop.customerNameToCityMap(): Map<String, City> =
    customers.associate{ c -> c.name to c.city }