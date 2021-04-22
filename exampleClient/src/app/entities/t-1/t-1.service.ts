import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { IT1 } from './it-1';
import { GenericApiService } from 'src/app/common/shared';

@Injectable({
  providedIn: 'root',
})
export class T1Service extends GenericApiService<IT1> {
  constructor(protected httpclient: HttpClient) {
    super(httpclient, 't1');
  }
}
