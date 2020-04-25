package guru.springframework.spring5webfluxrest.bootstrap;

import guru.springframework.spring5webfluxrest.domian.Category;
import guru.springframework.spring5webfluxrest.domian.Vendor;
import guru.springframework.spring5webfluxrest.repositories.CategoryRepository;
import guru.springframework.spring5webfluxrest.repositories.VendorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final VendorRepository vendorRepository;

    public Bootstrap(CategoryRepository categoryRepository, VendorRepository vendorRepository) {
        this.categoryRepository = categoryRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(categoryRepository.count().block()==0){
            //load data
            System.out.println("#### LOADING DATA ON BOOTSTRAP #######");
            categoryRepository.save(Category.builder()
                    .description("Fruits").build()).block();
            categoryRepository.save(Category.builder()
                    .description("Nuts").build()).block();
            categoryRepository.save(Category.builder()
                    .description("Breads").build()).block();
            categoryRepository.save(Category.builder()
                    .description("Meats").build()).block();
            categoryRepository.save(Category.builder()
                    .description("Eggs").build()).block();
            System.out.println("#### LOADED CATEGORIES : "+categoryRepository.count().block()+" #######");

            vendorRepository.save(Vendor.builder()
                    .firstName("Joe")
                    .lastName("Black").build()).block();
            vendorRepository.save(Vendor.builder()
                    .firstName("Micheal")
                    .lastName("Weston").build()).block();
            vendorRepository.save(Vendor.builder()
                    .firstName("Jessie")
                    .lastName("Watesr").build()).block();
            vendorRepository.save(Vendor.builder()
                    .firstName("John")
                    .lastName("B").build()).block();
            vendorRepository.save(Vendor.builder()
                    .firstName("Jimmy")
                    .lastName("Buffet").build()).block();
            System.out.println("#### LOADED VENORS : "+vendorRepository.count().block()+" #######");

        }
    }
}
