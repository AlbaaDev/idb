import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {MatCardModule} from '@angular/material/card';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from './components/header/header.component';
import { SideBareComponent } from './components/side-bare/side-bare.component';
import { FooterComponent } from './components/footer/footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatCheckboxModule} from '@angular/material/checkbox';
import {MatMenuModule} from '@angular/material/menu';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import { LoginComponent } from './pages/login/login/login.component';
import { SignUpComponent } from './pages/sign-up/sign-up.component';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatIconModule} from '@angular/material/icon';
import {MatInputModule} from '@angular/material/input';
import {ReactiveFormsModule, FormsModule} from '@angular/forms';
import { DashboardComponent } from './pages/dashboard/dashboard/dashboard.component';
import {MatTabsModule} from '@angular/material/tabs';
import { ResetPasswordComponent } from './pages/reset-password/reset-password.component';
import {MatSidenavModule} from '@angular/material/sidenav';
import { LayoutModule } from '@angular/cdk/layout';
import { MatListModule } from '@angular/material/list';
import { FacebookComponent } from './pages/facebook/facebook.component';
import {MatGridListModule} from '@angular/material/grid-list';
import { SettingsComponent } from './pages/settings/settings.component';
import { AccountService } from './services/user.service';
import { TransactionsComponent } from './pages/transactions/transactions.component';
import { CardsComponent } from './pages/cards/cards.component';
import { SendMoneyComponent } from './pages/send-money/send-money.component';
import {MatSelectModule} from "@angular/material/select";
import {MatRadioModule} from "@angular/material/radio";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SideBareComponent,
    FooterComponent,
    LoginComponent,
    SignUpComponent,
    DashboardComponent,
    ResetPasswordComponent,
    FacebookComponent,
    SettingsComponent,
    TransactionsComponent,
    CardsComponent,
    SendMoneyComponent,
  ],
  imports: [
    MatGridListModule,
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    MatMenuModule,
    BrowserAnimationsModule,
    MatCheckboxModule,
    MatButtonModule,
    MatToolbarModule,
    MatFormFieldModule,
    MatIconModule,
    MatInputModule,
    ReactiveFormsModule,
    MatTabsModule,
    MatCardModule,
    MatSidenavModule,
    LayoutModule,
    MatListModule,
    HttpClientModule,
    MatSelectModule,
    MatRadioModule
  ],
  providers: [AccountService],
  bootstrap: [AppComponent]
})
export class AppModule { }
