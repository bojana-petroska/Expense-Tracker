# Expense Tracker (Work in Progress)

## Overview
A simple Spring Boot backend application to manage personal expenses. Users can register, log in, add, update, and categorize expenses, and generate reports to track their spending habits over time.
____

## Features

***User Management***

- Register and authenticate users.
- Each user has a separate expense list.
  
***Expense Management***

- Add, update, delete expenses.
- Categorize expenses.
- Include descriptions and timestamps.

***Reports***

- View expenses for a specific day, week, or month.
- Group expenses by category.
- Alerts for exceeding a predefined budget.

___
  
## Technology Stack

- ***Backend:*** Java, Spring Boot.
- ***Database:*** PostgreSQL.
- ***Build Tool:*** Maven.
  
## Endpoints

Method	Endpoint	Description

<table>
  <thead>
    <tr style="background-color: #f5f5f5; color: #ff5722;">
      <th><b>Method</b></th>
      <th><b>Endpoint</b></th>
      <th><b>Description</b></th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><code>POST</code></td>
      <td><code>/users/register</code></td>
      <td>Register a new user.</td>
    </tr>
    <tr>
      <td><code>POST</code></td>
      <td><code>/users/login</code></td>
      <td>Authenticate a user.</td>
    </tr>
    <tr>
      <td><code>GET</code></td>
      <td><code>/expenses</code></td>
      <td>Get all user expenses.</td>
    </tr>
    <tr>
      <td><code>POST</code></td>
      <td><code>/expenses</code></td>
      <td>Add a new expense.</td>
    </tr>
    <tr>
      <td><code>PUT</code></td>
      <td><code>/expenses/{id}</code></td>
      <td>Update an existing expense.</td>
    </tr>
    <tr>
      <td><code>DELETE</code></td>
      <td><code>/expenses/{id}</code></td>
      <td>Delete an expense.</td>
    </tr>
    <tr>
      <td><code>GET</code></td>
      <td><code>/expenses/report</code></td>
      <td>Generate expense reports.</td>
    </tr>
  </tbody>
</table>


