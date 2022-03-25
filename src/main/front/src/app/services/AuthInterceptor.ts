/*
import {
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpInterceptor,
  HttpRequest,
  HttpResponse
} from "@angular/common/http";
import {Observable, tap} from "rxjs";
import {Router} from "@angular/router";

export class AuthInterceptor implements HttpInterceptor {
  private router: Router;

  constructor(router: Router) {
    this.router = router;
  }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return next.handle(request).pipe(tap(event => {
        if (event instanceof HttpResponse) {
          console.log(event);
        }
   }, (error: any) => {
      if (error instanceof HttpErrorResponse) {
          console.log(error);
      }
    }));
  }
}
*/
