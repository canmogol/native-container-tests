var count = 0;
function handler(_req: Request): Response {
  count++;
  console.log("Request #", count);
  return new Response("Hello, World!");
}
Deno.serve({"port":8080}, handler);
