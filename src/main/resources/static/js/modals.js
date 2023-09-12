const imageModal = document.getElementById("imageModal");
if (imageModal) {
    imageModal.addEventListener("show.bs.modal", (event) => {
        // Button that triggered the modal
        const button = event.relatedTarget;
        // Extract info from data-bs-* attributes
        const title = button.getAttribute("data-bs-title");
        const image = button.getAttribute("data-bs-image");
        // If necessary, you could initiate an Ajax request here
        // and then do the updating in a callback.

        // Update the modal's content.
        const modalTitle = imageModal.querySelector(".modal-title");
        const modalImage = imageModal.querySelector(".modal-body img");

        modalTitle.textContent = title;
        modalImage.src = image;
    });
}
