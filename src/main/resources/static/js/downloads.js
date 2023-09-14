function download(version, sender) {
    const element = document.getElementById(sender);
    const innerHtml = element.innerHTML;

    element.innerHTML = 'Preparing download <span class="spinner-border spinner-border-sm" aria-hidden="true"></span>';
    element.disabled = true;

    fetch("/downloads/" + version, {
        method: "GET"
    })
    .then(response => response.blob())
    .then(data => {
        const a = document.createElement("a");
        a.href = window.URL.createObjectURL(data);
        a.download = "obision-" + version + ".iso";
        a.click();
    })
    .finally(() => {
        element.disabled = false;
        element.innerHTML = innerHtml;
    });
}
