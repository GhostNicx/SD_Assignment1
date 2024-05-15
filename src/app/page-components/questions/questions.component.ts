import { Component } from '@angular/core';

@Component({
  selector: 'app-questions',
  templateUrl: './questions.component.html',
  styleUrl: './questions.component.css'
})
export class QuestionsComponent {
  crtUser: any = localStorage.getItem('user')? JSON.parse(localStorage.getItem('user') as string):{}

}
