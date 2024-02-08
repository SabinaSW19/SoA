import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Book} from "./book.model";
import {Review} from "./review.model";

@Injectable()
export class Service {

  private apiBaseURL = 'http://localhost:8099';
  private urlBook = 'http://localhost:8090';
  private urlReview = 'http://localhost:8092';
  constructor(private httpClient: HttpClient) {
  }

  addBook(book: string ): Observable<Array<Book>>{
    //const imageToSend = image.split('\\');
    console.log(book);
   // const image2: ImageName = new ImageName();
    //image2.image = imageToSend[2];
    console.log(`${this.urlBook}/book/${book}`);
    return this.httpClient
      .get<Array<Book>>(`${this.urlBook}/book/${book}`);
  }


  getBooks(): Observable<Array<Book>>{
    //const imageToSend = image.split('\\');

    // const image2: ImageName = new ImageName();
    //image2.image = imageToSend[2];
    console.log(`${this.urlBook}/books`);
    return this.httpClient
      .get<Array<Book>>(`${this.urlBook}/books`);
  }

  borrowBook(book: string ): void {
    console.log(`${this.urlBook}/borrow`);
      this.httpClient
        .post(`${this.urlBook}/borrow/${book}`,book).subscribe();
    }

  getReviews(book: string ): Observable<Array<Review>>{
    //const imageToSend = image.split('\\');
    console.log(book);
    // const image2: ImageName = new ImageName();
    //image2.image = imageToSend[2];
    console.log(`${this.urlReview}/review/${book}`);
    return this.httpClient
      .get<Array<Review>>(`${this.urlReview}/review/${book}`);
  }

  // getResults(): Observable<Array<Prediction>> {
  //   console.log('here');
  //   return this.httpClient.get<Array<Prediction>>(`${this.apiBaseURL}/getResults`);
  // }
  //
  // makePredictionAppropriate(image: string ): void {
  //   const imageToSend = image.split('\\');
  //   console.log(imageToSend[2]);
  //   const image2: ImageName = new ImageName();
  //   image2.image = imageToSend[2];
  //   this.httpClient
  //     .post(`${this.apiBaseURL}/predictAppropriate`, image2).subscribe();
  // }
  //
  // getResultsAppropriate(): Observable<Array<PredictionAppropriate>> {
  //   console.log('here');
  //   return this.httpClient.get<Array<PredictionAppropriate>>(`${this.apiBaseURL}/getAppropriate`);
  // }

}
