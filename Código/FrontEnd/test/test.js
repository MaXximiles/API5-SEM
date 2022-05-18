/* eslint-disable no-undef */
/* eslint-disable @typescript-eslint/no-var-requires */
const request = require("supertest");
const app = require("../views/crafted/authentication/basic-flow/SignIn.vue");

describe("GET /", () => {
  it("responds with Hello World!", (done) => {
    request(app).get("/").expect("Hello my friends!", done);
  });
});
