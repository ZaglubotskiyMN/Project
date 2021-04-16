package TestsAPI;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestsProjectAPI {


  @Test
  @Owner("ZaglubotskiyMN")
  @Description("Авторизация")
  public void authorizationTest(){
      given()
              .contentType(ContentType.JSON)
              //.log().all()
              .filter(new AllureRestAssured())
              .body("{\n" +
                      "    \"userName\":\"USER64\", \n" +
                      "     \"password\":\"Tz12345!\" \n" +
                      "}"
              )
              .when()
              .post("https://demoqa.com/Account/v1/Authorized")
              .then()
              //.log().all()
              .statusCode(200);
  }

  @Test
  @Owner("ZaglubotskiyMN")
  @Description("Вывод всех книг")
    public void bookview(){
       given()
              .filter(new AllureRestAssured())
              .when()
              .get("https://demoqa.com/BookStore/v1/Books")
              .then()
              .log().body()
              .statusCode(200);
  }

  @Test
  @Owner("ZaglubotskiyMN")
  @Description("Добавляем книгу")
  public void collectionadd(){
    given()
            .contentType(ContentType.JSON)
            .auth()
            .preemptive()
            .basic("USER64","Tz12345!")
            .log().all()
            .filter(new AllureRestAssured())
            .body("{\n" +
                    "    \"userId\":\"77650cb3-e1e8-46e3-b8c8-00fcc73b03e8\", \n" +
                    "     \"collectionOfIsbns\":[\n"+
                    "{\n" +
                    "     \"isbn\":\"9781449331818\" \n"+
                    "}\n" +
                    "]\n" +
                    "}"

            )
            .when()
            .post("https://demoqa.com/BookStore/v1/Books")
            .then()
            .log().body()
            .statusCode(201);

  }
    @Test
    @Owner("ZaglubotskiyMN")
    @Description("Удаляем книгу")
    public void deletebook(){
      given()
              .contentType(ContentType.JSON)
              .auth()
              .preemptive()
              .basic("USER64","Tz12345!")
              .log().all()
              .filter(new AllureRestAssured())
              .body("{\n" +
                      "    \"isbn\":\"9781449331818\", \n" +
                      "     \"userId\":\"77650cb3-e1e8-46e3-b8c8-00fcc73b03e8\" \n" +
                      "}"

              )
              .when()
              .delete("https://demoqa.com/BookStore/v1/Book")
              .then()
              .log().all()
              .statusCode(204);
    }




  }


   //
      //given()




