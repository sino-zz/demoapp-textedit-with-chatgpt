<!DOCTYPE html>
<html>
  <head>
    <title>Chat Application</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  </head>
  <body>
    <div class="container mt-5">
      <h1 class="text-center">Say it in your way</h1>
      <div class="form-group mt-5">
        <textarea id="inputMessage" class="form-control mb-3" placeholder="Say it in your way"></textarea>
        <div class="text-center">
          <input type="submit" id="submitBtn" class="btn btn-primary" value="Submit" />
        </div>
      </div>
      <div class="form-group mt-5">
      <h1 class="text-center">Professionals say it,</h1>
        <textarea id="outputMessage" class="form-control" placeholder="Messages will be displayed here" disabled></textarea>
      </div>
    </div>
    <script>
      document.getElementById("submitBtn").addEventListener("click", function() {
        let inputMessage = document.getElementById("inputMessage").value;
        let outputMessage = document.getElementById("outputMessage").value;
        outputMessage = outputMessage + "\n" + inputMessage;
        document.getElementById("outputMessage").value = outputMessage;
        document.getElementById("inputMessage").value = "";
      });
    </script>
  </body>
</html>
