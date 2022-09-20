package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("=== TEST1: seller findById ====");
		Seller seller = sellerDao.findByIdt(3);
		System.out.println(seller);
		
		System.out.println("\n=== TEST2: seller findById ====");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for(Seller obj: list) {
			System.out.println((obj));
		}
		
		System.out.println("\n=== TEST3: seller findById ====");
		list = sellerDao.findAll();
		for(Seller obj: list) {
			System.out.println((obj));
		}
		
		System.out.println("\n=== TEST4: seller insert ====");
		Seller newseller = new Seller (null, "Greg", "grege@gmail.com", new Date(), 4000.0,department);
		sellerDao.insert(newseller);
		System.out.println("Inserted! new Id = " + newseller.getId());
		
		System.out.println("\n=== TEST5: seller insert ====");
		seller = sellerDao.findByIdt(1);
		seller.setName("Marta Waine");
		sellerDao.update(seller);
		System.out.println("Update complete!");
	}

}
