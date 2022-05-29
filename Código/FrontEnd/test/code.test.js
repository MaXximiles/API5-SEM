/* eslint-disable @typescript-eslint/no-unused-vars */
/* eslint-disable @typescript-eslint/no-var-requires */
/* eslint-disable no-undef */
/* eslint-disable @typescript-eslint/no-empty-function */

const { sum } = require("./code.js");

describe("math functions", () => {
  it("sums 2 numbers", () => {
    expect(sum(1, 2)).toBe(3);
  });
});
