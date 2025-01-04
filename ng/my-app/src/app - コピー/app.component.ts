import { Component, inject, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { FormControl, FormGroup, Validators, FormBuilder } from '@angular/forms';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ReactiveFormsModule, NgIf],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {
  title = 'my-app';
  theme = 'dark';
  id = 'Test';
  isFormValid: any;
  isDeleteSuccess: boolean = true;
  // name = new FormControl('');
  private formBuilder = inject(FormBuilder);
  controlForm!: FormGroup;

  ngOnInit(): void {
    // controlForm = new FormGroup({

    //   name: new FormControl(''),
    //   selectBtn: new FormControl('')
    // });
    this.controlForm = this.formBuilder.group({
      name: ['', [Validators.required, Validators.minLength(4)]],
      selectBtn: ['', [Validators.required, Validators.pattern('[1-3]')]],
    });
  }
  onSubmit() {
    console.warn(this.controlForm.value);
    console.log(this.controlForm.errors); // {pattern: {requiredPattern: '^[a-zA-Z ]*$', actualValue: '1'}}
  }
  get name(): FormControl {
    return this.controlForm.get('name') as FormControl
  }

}
