import { Component, inject, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormControl, FormGroup, Validators, FormBuilder } from '@angular/forms';
import { CommonModule, NgIf } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ReactiveFormsModule, NgIf,FormsModule,CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {
  title = 'my-app';
  theme = 'dark';
  id! : null;
  isFormValid: any;
  isDeleteSuccess: boolean = true;
  // name = new FormControl('');
  // private formBuilder = inject(FormBuilder);
  controlForm!: FormGroup;

  ngOnInit(): void {
    this.controlForm = new FormGroup({
      name: new FormControl("",[Validators.required,Validators.minLength(4)]),
      selectBtn: new FormControl(""),
    });
  }
  onSubmit() {
    console.warn(this.controlForm.value);
    console.log(this.controlForm.errors); // {pattern: {requiredPattern: '^[a-zA-Z ]*$', actualValue: '1'}}
  }
  get name(){
    return this.controlForm.get('name');
  }

}
