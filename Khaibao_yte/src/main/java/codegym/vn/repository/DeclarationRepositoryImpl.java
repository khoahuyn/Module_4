package codegym.vn.repository;

import codegym.vn.model.Declaration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DeclarationRepositoryImpl implements DeclarationRepository {

    public static List<String> yearOfBirthList=new ArrayList<>();
    public static List<String> genderList = new ArrayList<>();
    public static List<String> nationalityList= new ArrayList<>();
    public static List<String> vehicleList = new ArrayList<>();
    public static Map<String, Declaration> declarationMap = new HashMap<>();


    static {
        yearOfBirthList.add("1990");
        yearOfBirthList.add("1995");
        yearOfBirthList.add("2000");
        yearOfBirthList.add("2005");
        yearOfBirthList.add("2010");

        genderList.add("Nam");
        genderList.add("Nữ");
        genderList.add("Không rõ");

        nationalityList.add("Việt Nam");
        nationalityList.add("USA");
        nationalityList.add("Janpanese");
        nationalityList.add("Khác (Ghi rõ)");

        vehicleList.add("Tàu bay");
        vehicleList.add("Tàu thuyền");
        vehicleList.add("Ô tô");
        vehicleList.add("Khác (Ghi rõ)");



        declarationMap.put("08369", new Declaration("Yenne", "2002", "Nữ", "Việt Nam", "08369", "Tàu bay", "92-F4","50", "01/05/2023", "06/05/2023", "Không bệnh tật","Quảng Nam", "Đại Lộc", "Đại Hiệp", "120/24 đại lộc","096972534", "bronyaOneechan@gmail.com"));
        declarationMap.put("03696", new Declaration("Bongchu", "1999", "Nam", "Việt Nam", "03696", "Ô tpp", "42-F1","25", "26/05/2023", "01/06/2023", "Có tiếp xúc f1","Đà Nẵng", "Hải Châu", "Bình Thuận", "250.5 hoàng hoa thám","082251467", "jingLiuSensei@gmail.com"));
        declarationMap.put("07375", new Declaration("Kalifa", "2000", "Nữ", "Việt Nam", "07375", "Tàu thuyền", "74-B5","45a", "01/05/2023", "06/05/2023", "Tự cách ly","Đà Nẵng", "Cẩm Lệ", "Hòa Xuân", "49 nguyễn diệu","076927108", "stelle@gmail.com"));

    }

    @Override
    public List<Declaration> findAll() {
        return new ArrayList<>(declarationMap.values());
    }

    @Override
    public List<String> yearOfBirthList() {
        return yearOfBirthList;
    }

    @Override
    public List<String> genderList() {
        return genderList;
    }

    @Override
    public List<String> nationalityList() {
        return nationalityList;
    }

    @Override
    public List<String> vehicleList() {
        return vehicleList;
    }

    @Override
    public void create(Declaration declaration) {
        declarationMap.put(declaration.getIdentifyCard(), declaration);
    }

    @Override
    public boolean update(Declaration declaration) {
        if (declarationMap.containsKey(declaration.getIdentifyCard())) {
            declarationMap.put(declaration.getIdentifyCard(), declaration);
            return true;
        }
        return false;
    }

    @Override
    public Declaration findByIdentifyCard(String ICard) {
        return declarationMap.get(ICard);
    }
}
