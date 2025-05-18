package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final InhousePartRepository inhousePartRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, InhousePartRepository inhousePartRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.inhousePartRepository = inhousePartRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<InhousePart> inhouseParts = (List<InhousePart>) inhousePartRepository.findAll();
        List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
        List<Product> products = (List<Product>) productRepository.findAll();

        if (inhouseParts.isEmpty() && outsourcedParts.isEmpty() && products.isEmpty()) {

            InhousePart ih1 = new InhousePart();
            ih1.setName("Carbon Diffuser");
            ih1.setInv(5);
            ih1.setPrice(1200.00);
            ih1.setId(1);
            ih1.setMinInv(0);
            ih1.setMaxInv(100);
            inhousePartRepository.save(ih1);
            InhousePart thePart = null;
            inhouseParts = (List<InhousePart>) inhousePartRepository.findAll();
            for (InhousePart part : inhouseParts) {
                if (part.getName().equals("Carbon Diffuser")) thePart = part;
            }

            InhousePart ih2 = new InhousePart();
            ih2.setName("Carbon Splitter");
            ih2.setInv(3);
            ih2.setPrice(1150.00);
            ih2.setId(2);
            ih1.setMinInv(0);
            ih1.setMaxInv(100);
            inhousePartRepository.save(ih2);
            thePart = null;
            inhouseParts = (List<InhousePart>) inhousePartRepository.findAll();
            for (InhousePart part : inhouseParts) {
                if (part.getName().equals("Carbon Splitter")) thePart = part;
            }

            inhouseParts = (List<InhousePart>) inhousePartRepository.findAll();
            for (InhousePart part : inhouseParts) {
                System.out.println(part.getName() + " " + part.getId());
            }

            OutsourcedPart os1 = new OutsourcedPart();
            os1.setCompanyName("PDL");
            os1.setName("Header");
            os1.setInv(23);
            os1.setPrice(700.00);
            os1.setId(1L);
            ih1.setMinInv(0);
            ih1.setMaxInv(100);
            outsourcedPartRepository.save(os1);
            OutsourcedPart theOutPart = null;
            outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("Header")) theOutPart = part;
            }

            System.out.println(theOutPart.getCompanyName());

            OutsourcedPart os2 = new OutsourcedPart();
            os2.setCompanyName("AWK");
            os2.setName("Mid-Pipe");
            os2.setInv(17);
            os2.setPrice(1100.00);
            os2.setId(2L);
            ih1.setMinInv(0);
            ih1.setMaxInv(100);
            outsourcedPartRepository.save(os2);
            theOutPart = null;
            outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("Mid-Pipe")) theOutPart = part;
            }

            System.out.println(theOutPart.getCompanyName());

            OutsourcedPart os3 = new OutsourcedPart();
            os3.setCompanyName("Momei");
            os3.setName("Cat-Back Exhaust");
            os3.setInv(11);
            os3.setPrice(1300.00);
            os3.setId(3L);
            ih1.setMinInv(0);
            ih1.setMaxInv(100);
            outsourcedPartRepository.save(os3);
            theOutPart = null;
            outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("Cat-Back Exhaust")) theOutPart = part;
            }

            System.out.println(theOutPart.getCompanyName());

            outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                System.out.println(part.getName() + " " + part.getCompanyName());
            }

            Product Lug_nuts = new Product("Lug nuts", 45.00, 47);
            Product Air_filter = new Product("Air filter", 65.00, 19);
            Product Cabin_filter = new Product("Cabin Filter", 15.00, 84);
            Product Oil_filter = new Product("Oil Filter", 25.00, 31);
            Product Coolant = new Product("Coolant", 37.00, 6);

            productRepository.save(Lug_nuts);
            productRepository.save(Air_filter);
            productRepository.save(Cabin_filter);
            productRepository.save(Oil_filter);
            productRepository.save(Coolant);

            System.out.println("Started in Bootstrap");
            System.out.println("Number of Products" + productRepository.count());
            System.out.println(productRepository.findAll());
            System.out.println("Number of Parts" + partRepository.count());
            System.out.println(partRepository.findAll());
        }
    }
}
